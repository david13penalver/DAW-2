# File Status Lifecycle

![File Status Lifecycle](./Assets/05_git_status.png)

- `git restore` in the staging area does not work. It only works in the working directory. To restore a file in the staging area, you need to use `git restore --staged <file>`.
- `git resto` in an untracked file does not work.
- `git rm --cached <file>` removes a file from the committed area but keeps it in the working directory. 
  - It is useful when you want to stop tracking a file but keep it in your working directory.
  - If you want to delete it permanently, you can use `git rm <file>`.
  - If you want to delete it permanently from the command line, you can use `git rm <file> -f`.
- `git stash` is used to save the current state of the working directory and the staging area. It is useful when you want to switch branches without committing your changes.
  - `git stash push` is the same as `git stash`.
  - `git stash push --all` stashes all changes, including untracked files.   