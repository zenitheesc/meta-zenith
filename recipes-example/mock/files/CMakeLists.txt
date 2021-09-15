cmake_minimum_required(VERSION 3.16.3)

set(CMAKE_EXPORT_COMPILE_COMMANDS ON)
add_compile_options(-std=c++17)
set(CMAKE_CXX_STANDARD 17)

project(PingPong)

# First, find sdbus-c++
find_package(sdbus-c++ REQUIRED)

# Use the sdbus-c++ target in SDBusCpp namespace
add_executable(server server.cpp)
add_executable(cliente cliente.cpp)

target_link_libraries(server PRIVATE SDBusCpp::sdbus-c++)
target_link_libraries(cliente PRIVATE SDBusCpp::sdbus-c++)

# Install configuration file
install (FILES org.sdbuscpp.counter.conf DESTINATION /etc/dbus-1/system.d)

# Install systemd unit files
install (FILES server.service cliente.service DESTINATION /lib/systemd/system)

# Install the binary
install (TARGETS server cliente RUNTIME DESTINATION /usr/bin)