# Installing Git

Important step in Windows:
- Choosing default editor: **Vim**, Nano, Notepad++, etc.
- Adjusting PATH environment: Use Git and optional Unix tools from the Windows Command Prompt (the one with the warning).   
- Choose the default behavior of `git pull`: Only even fast-forward.
  - To change it in Linux: `git config --global pull.ff only`.
```bash
git config --global core.editor "vim"
                                git config --global pull.ff only
```
// ruta de git config global en Linux: `~/.gitconfig`

The rest is `Next`.

# What Not To Do on CSS

- Don't use `!important`.
- Only use the `.` selector.
  - We want reusable classes.
- Don't use tag selectors.