# ModularAIDL
This app demonstrates the following situation. You've two modules (ModuleA and ModuleB), where ModuleB (client) is dependent on ModuleB (server).
But the requirement is that both should be shipped separately as modular SDK. Then we can resolve this requirement using AIDL keeping obfuscation in mind.

Check ModuleA which declares the dependent class.
Check ModuleB which uses ModuleA when called.