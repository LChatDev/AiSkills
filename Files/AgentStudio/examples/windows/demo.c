typedef unsigned short W;
__declspec(dllimport) int __stdcall MessageBoxW(void*,const W*,const W*,unsigned int);
__declspec(dllimport) void __stdcall ExitProcess(unsigned int);
void mainCRTStartup(void) {
  MessageBoxW(0, L"AgentStudio | Demo ready.\nA small, local, offline Windows example.", L"AgentStudio / Studio100", 0x40);
  ExitProcess(0);
}
