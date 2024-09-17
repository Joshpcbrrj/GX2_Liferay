package br.com.gx2.application;

import br.com.gx2.model.Task;
import br.com.gx2.model.impl.TaskImpl;
import br.com.gx2.service.TaskLocalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Custom REST API for Task entity
 */
@Component(
		property = {
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/task-api",
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=Task-api.Rest"
		},
		service = Application.class
)
public class RestTasksApplication extends Application {

	@Reference
	private TaskLocalService _taskLocalService;

	@Override
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	// Exemplo de método de teste
	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	// 1. Método REST para listar todas as tarefas
	@GET
	@Path("/tasks")
	@Produces("application/json")
	public List<Task> getAllTasks() {
		return _taskLocalService.getAllTasks();
	}

	// 2. Método REST para obter uma tarefa por ID
	@GET
	@Path("/tasks/{taskId}")
	@Produces("application/json")
	public Task getTaskById(@PathParam("taskId") long taskId) throws PortalException {
		return _taskLocalService.getTaskById(taskId);
	}

	// 3. Método REST para criar uma nova tarefa
	@POST
	@Path("/tasks")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createTask(String body) {
		try {
			// Convertendo o corpo JSON para um objeto Task
			ObjectMapper objectMapper = new ObjectMapper();
//			Task task = objectMapper.readValue(body, Task.class);

			Task task = new TaskImpl();

			task.setTitle("test");
			task = objectMapper.readValue(body, TaskImpl.class);

			// Use uma nova instância de ServiceContext sem precisar de requisição
			ServiceContext serviceContext = new ServiceContext();

			// Criando a nova tarefa
			Task newTask = _taskLocalService.createTask(
					task.getTitle(),
					task.getDescription(),
					task.getDueDate(),
					task.isCompleted(),
					serviceContext
			);

			return Response.ok(newTask).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao processar o JSON de entrada: " + e.getMessage()).build();
		}
	}

	// 4. Método REST para atualizar uma tarefa por ID
	@PUT
	@Path("/tasks/{taskId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateTask(
			@PathParam("taskId") long taskId, Task task) {
		try {
			// Use uma nova instância de ServiceContext sem precisar de requisição
			ServiceContext serviceContext = new ServiceContext();

			Task updatedTask = _taskLocalService.updateTask(
					taskId,
					task.getTitle(),
					task.getDescription(),
					task.getDueDate(),
					task.isCompleted(),
					serviceContext
			);

			return Response.ok(updatedTask).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	// 5. Método REST para apagar uma tarefa por ID
	@DELETE
	@Path("/tasks/{taskId}")
	@Produces("application/json")
	public Response deleteTask(@PathParam("taskId") long taskId) {
		try {
			Task deletedTask = _taskLocalService.deleteTask(taskId);
			return Response.ok(deletedTask).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
		}
	}
}