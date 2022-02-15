cls
echo Realmente deseja fazer backup?
pause

cls
echo Fazendo backup...
cd C:\Users\usuario
mkdir backup

xcopy /E /Y "C:\Users\usuario\codigo" "C:\Users\usuario\backup"

echo Listando arquivos do backup
dir C:\Users\usuario\backup
