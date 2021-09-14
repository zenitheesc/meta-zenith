#include <sdbus-c++/sdbus-c++.h>
#include <vector>
#include <string>

// Yeah, global variable is ugly, but this is just an example and we want to access
// the counter instance from within the concatenate method handler to be able
// to emit signals.
sdbus::IObject* g_counter{};

void concatenate(sdbus::MethodCall call)
{
    // Deserialize the collection of numbers from the message
    int number = NULL;
    call >> number;

    // Return error if there are no numbers in the collection
    if (number == NULL)
        throw sdbus::Error("org.sdbuscpp.Counter.Error", "No number provided");
    number++;
    // Serialize resulting string to the reply and send the reply to the caller
    auto reply = call.createReply();
    reply << number;
    reply.send();

    // Emit 'concatenated' signal
    const char* interfaceName = "org.sdbuscpp.Counter";
    auto signal = g_counter->createSignal(interfaceName, "concatenated");
    signal << number;
    g_counter->emitSignal(signal);
}

int main(int argc, char *argv[])
{
    // Create D-Bus connection to the system bus and requests name on it.
    const char* serviceName = "org.sdbuscpp.counter";
    auto connection = sdbus::createSystemBusConnection(serviceName);

    // Create counter D-Bus object.
    const char* objectPath = "/org/sdbuscpp/counter";
    auto counter = sdbus::createObject(*connection, objectPath);

    g_counter = counter.get();

    // Register D-Bus methods and signals on the counter object, and exports the object.
    const char* interfaceName = "org.sdbuscpp.Counter";
    counter->registerMethod(interfaceName, "concatenate", "i", "i", &concatenate);
    counter->registerSignal(interfaceName, "concatenated", "i");
    counter->finishRegistration();

    // Run the I/O event loop on the bus connection.
    connection->enterEventLoop();
}
