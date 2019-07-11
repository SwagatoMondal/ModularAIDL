# ModularAIDL
This app demonstrates the following situation. You've two modules (ModuleA and ModuleB), where ModuleB (client) is dependent on ModuleA (server).
But the requirement is that both should be shipped separately as modular SDK. Then we can resolve this requirement using AIDL keeping obfuscation in mind.

Check ModuleA which declares the dependent class.
Check ModuleB which uses ModuleA when called.

## Android Documentation Referred
https://developer.android.com/guide/components/aidl#java

## Steps to build the app
Build the project and place the AAR(s) of Module A & B inside the App module and then run.
