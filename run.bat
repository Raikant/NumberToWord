set ProjectPath=C:\Users\pathakr\workspace_1\mv_dll
echo %ProjectPath%
set classpath=%ProjectPath%\lib\*
echo %classpath%
java maven.DllMain
pause