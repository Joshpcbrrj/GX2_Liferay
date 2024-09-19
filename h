[4mGIT-STASH[24m(1)                                                                                                            Git Manual                                                                                                            [4mGIT-STASH[24m(1)

[1mNAME[0m
       git-stash - Stash the changes in a dirty working directory away

[1mSYNOPSIS[0m
       [4mgit[24m [4mstash[24m list [<log-options>]
       [4mgit[24m [4mstash[24m show [-u | --include-untracked | --only-untracked] [<diff-options>] [<stash>]
       [4mgit[24m [4mstash[24m drop [-q | --quiet] [<stash>]
       [4mgit[24m [4mstash[24m pop [--index] [-q | --quiet] [<stash>]
       [4mgit[24m [4mstash[24m apply [--index] [-q | --quiet] [<stash>]
       [4mgit[24m [4mstash[24m branch <branchname> [<stash>]
       [4mgit[24m [4mstash[24m [push [-p | --patch] [-S | --staged] [-k | --[no-]keep-index] [-q | --quiet]
                    [-u | --include-untracked] [-a | --all] [(-m | --message) <message>]
                    [--pathspec-from-file=<file> [--pathspec-file-nul]]
                    [--] [<pathspec>...]]
       [4mgit[24m [4mstash[24m save [-p | --patch] [-S | --staged] [-k | --[no-]keep-index] [-q | --quiet]
                    [-u | --include-untracked] [-a | --all] [<message>]
       [4mgit[24m [4mstash[24m clear
       [4mgit[24m [4mstash[24m create [<message>]
       [4mgit[24m [4mstash[24m store [(-m | --message) <message>] [-q | --quiet] <commit>

[1mDESCRIPTION[0m
       Use [1mgit stash [22mwhen you want to record the current state of the working directory and the index, but want to go back to a clean working directory. The command saves your local modifications away and reverts the working directory to match the
       [1mHEAD [22mcommit.

       The modifications stashed away by this command can be listed with [1mgit stash list[22m, inspected with [1mgit stash show[22m, and restored (potentially on top of a different commit) with [1mgit stash apply[22m. Calling [1mgit stash [22mwithout any arguments is
       equivalent to [1mgit stash push[22m. A stash is by default listed as "WIP on [4mbranchname[24m ...", but you can give a more descriptive message on the command line when you create one.

       The latest stash you created is stored in [1mrefs/stash[22m; older stashes are found in the reflog of this reference and can be named using the usual reflog syntax (e.g. [1mstash@{0} [22mis the most recently created stash, [1mstash@{1} [22mis the one before it,
       [1mstash@{2.hours.ago} [22mis also possible). Stashes may also be referenced by specifying just the stash index (e.g. the integer [1mn [22mis equivalent to [1mstash@{n}[22m).

[1mCOMMANDS[0m
       push [-p|--patch] [-S|--staged] [-k|--[no-]keep-index] [-u|--include-untracked] [-a|--all] [-q|--quiet] [(-m|--message) <message>] [--pathspec-from-file=<file> [--pathspec-file-nul]] [--] [<pathspec>...]
           Save your local modifications to a new [4mstash[24m [4mentry[24m and roll them back to HEAD (in the working tree and in the index). The <message> part is optional and gives the description along with the stashed state.

           For quickly making a snapshot, you can omit "push". In this mode, non-option arguments are not allowed to prevent a misspelled subcommand from making an unwanted stash entry. The two exceptions to this are [1mstash -p [22mwhich acts as alias for
           [1mstash push -p [22mand pathspec elements, which are allowed after a double hyphen [1m-- [22mfor disambiguation.

       save [-p|--patch] [-S|--staged] [-k|--[no-]keep-index] [-u|--include-untracked] [-a|--all] [-q|--quiet] [<message>]
           This option is deprecated in favour of [4mgit[24m [4mstash[24m [4mpush[24m. It differs from "stash push" in that it cannot take pathspec. Instead, all non-option arguments are concatenated to form the stash message.

       list [<log-options>]
           List the stash entries that you currently have. Each [4mstash[24m [4mentry[24m is listed with its name (e.g.  [1mstash@{0} [22mis the latest entry, [1mstash@{1} [22mis the one before, etc.), the name of the branch that was current when the entry was made, and a short
           description of the commit the entry was based on.

               stash@{0}: WIP on submit: 6ebd0e2... Update git-stash documentation
               stash@{1}: On master: 9cc0589... Add git-stash

           The command takes options applicable to the [4mgit[24m [4mlog[24m command to control what is shown and how. See [1mgit-log[22m(1).

       show [-u|--include-untracked|--only-untracked] [<diff-options>] [<stash>]
           Show the changes recorded in the stash entry as a diff between the stashed contents and the commit back when the stash entry was first created. By default, the command shows the diffstat, but it will accept any format known to [4mgit[24m [4mdiff[0m
           (e.g., [1mgit stash show -p stash@{1} [22mto view the second most recent entry in patch form). If no [1m<diff-option> [22mis provided, the default behavior will be given by the [1mstash.showStat[22m, and [1mstash.showPatch [22mconfig variables. You can also use
           [1mstash.showIncludeUntracked [22mto set whether [1m--include-untracked [22mis enabled by default.

       pop [--index] [-q|--quiet] [<stash>]
           Remove a single stashed state from the stash list and apply it on top of the current working tree state, i.e., do the inverse operation of [1mgit stash push[22m. The working directory must match the index.

           Applying the state can fail with conflicts; in this case, it is not removed from the stash list. You need to resolve the conflicts by hand and call [1mgit stash drop [22mmanually afterwards.

       apply [--index] [-q|--quiet] [<stash>]
           Like [1mpop[22m, but do not remove the state from the stash list. Unlike [1mpop[22m, [1m<stash> [22mmay be any commit that looks like a commit created by [1mstash push [22mor [1mstash create[22m.

       branch <branchname> [<stash>]
           Creates and checks out a new branch named [1m<branchname> [22mstarting from the commit at which the [1m<stash> [22mwas originally created, applies the changes recorded in [1m<stash> [22mto the new working tree and index. If that succeeds, and [1m<stash> [22mis a
           reference of the form [1mstash@{<revision>}[22m, it then drops the [1m<stash>[22m.

           This is useful if the branch on which you ran [1mgit stash push [22mhas changed enough that [1mgit stash apply [22mfails due to conflicts. Since the stash entry is applied on top of the commit that was HEAD at the time [1mgit stash [22mwas run, it restores the
           originally stashed state with no conflicts.

       clear
           Remove all the stash entries. Note that those entries will then be subject to pruning, and may be impossible to recover (see [4mExamples[24m below for a possible strategy).

       drop [-q|--quiet] [<stash>]
           Remove a single stash entry from the list of stash entries.

       create
           Create a stash entry (which is a regular commit object) and return its object name, without storing it anywhere in the ref namespace. This is intended to be useful for scripts. It is probably not the command you want to use; see "push"
           above.

       store
           Store a given stash created via [4mgit[24m [4mstash[24m [4mcreate[24m (which is a dangling merge commit) in the stash ref, updating the stash reflog. This is intended to be useful for scripts. It is probably not the command you want to use; see "push" above.

[1mOPTIONS[0m
       -a, --all
           This option is only valid for [1mpush [22mand [1msave [22mcommands.

           All ignored and untracked files are also stashed and then cleaned up with [1mgit clean[22m.

       -u, --include-untracked, --no-include-untracked
           When used with the [1mpush [22mand [1msave [22mcommands, all untracked files are also stashed and then cleaned up with [1mgit clean[22m.

           When used