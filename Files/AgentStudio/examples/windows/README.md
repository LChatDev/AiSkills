# Windows demo

StudioDemo.exe — локальный диалог Windows x64, без сети, сбора данных и автозапуска. Собран clang/lld-link, проверен PE32+ и импорты; запуск Windows не проведён. Не подписан.

SHA256: 2e1ec2bc27cc623bfec969606e66e4391562b47808ebf28641aeee3195867b88

Сборка с Windows SDK import libraries: clang --target=x86_64-pc-windows-msvc -c -Os -ffreestanding -fno-stack-protector demo.c -o demo.obj; lld-link /entry:mainCRTStartup /subsystem:windows /nodefaultlib /opt:ref /opt:icf /out:StudioDemo.exe demo.obj user32.lib kernel32.lib. Не запускай скачанное ПО автоматически.
