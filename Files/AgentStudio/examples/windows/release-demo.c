#define UNICODE
#define _UNICODE
#include <windows.h>
int WINAPI wWinMain(HINSTANCE instance,HINSTANCE previous,PWSTR command,int show) {
    (void)instance; (void)previous; (void)command; (void)show;
    MessageBoxW(NULL,L"AgentStudio | Studio100\nA local, offline Windows demonstration.",L"AgentStudio 1.1",MB_OK|MB_ICONINFORMATION);
    return 0;
}
