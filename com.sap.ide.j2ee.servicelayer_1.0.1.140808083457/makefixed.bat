@echo off
set JN=com.sap.ide.j2ee.servicelayer_1.0.1.140808083457.jar
set JAR=C:\NWDSsp12.p4\plugins\%JN%
set ZIP="C:\Program Files\7-Zip\7z.exe"
set BLD=bin\com\sap\ide\j2ee\servicelayer\archive

copy/b %JAR% .
cd bin && %ZIP% a ..\%JN% com\sap\ide\j2ee\servicelayer\archive\*class
echo **************************************************************************
echo * Now replace:
echo * %JAR%
echo * with with .\%JN%
echo **************************************************************************
pause