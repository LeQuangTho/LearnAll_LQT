 #include <windows.h>
int WinMain (HINSTANCE hInstance, HINSTANCE hPrevInstance, PSTR szCmdLine, int iCmdShow)
{
     MessageBox (NULL, TEXT ("Hello, Windows 98!"), TEXT ("HelloMsg"),MB_OK|MB_ICONINFORMATION ) ;
     return 0 ;
}
