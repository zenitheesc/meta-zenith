#include <sdbus-c++/sdbus-c++.h>
#include <vector>
#include <string>
#include <iostream>
#include <unistd.h>

void onConcatenated(sdbus::Signal& signal)
{
    int number;
    signal >> number;

    std::cout << "Received signal with number " << number << std::endl;
}

int main(int argc, char *argv[])
{
    // Create proxy object for the counter object on the server side. Since here
    // we are creating the proxy instance without passing connection to it, the proxy
    // will create its own connection automatically, and it will be system bus connection.
    const char* destinationName = "org.sdbuscpp.counter";
    const char* objectPath = "/org/sdbuscpp/counter";
    auto counterProxy = sdbus::createProxy(destinationName, objectPath);

    // Let's subscribe for the 'concatenated' signals
    const char* interfaceName = "org.sdbuscpp.Counter";
    counterProxy->registerSignalHandler(interfaceName, "concatenated", &onConcatenated);
    counterProxy->finishRegistration();

    int number = 1;
    // Invoke concatenate on given interface of the object
    while(true){
        std::cout << "Sending method call with number " << number << std::endl;
        auto method = counterProxy->createMethodCall(interfaceName, "concatenate");
        method << number;

        sleep(1);
        auto reply = counterProxy->callMethod(method);
        reply >> number;
        std::cout << "Received method with number " << number << std::endl;

        number++;
        if(number > 100) number=1;
    }


    return 0;
}