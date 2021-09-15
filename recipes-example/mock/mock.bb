LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd
inherit cmake

DEPENDS+= " sdbus-c++"

SRC_URI_append = "\
file://cliente.service \
file://server.service  \
file://server.cpp \
file://cliente.cpp \
file://org.sdbuscpp.counter.conf \
file://CMakeLists.txt \
"

S = "${WORKDIR}"
SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "cliente.service"
SYSTEMD_SERVICE_${PN} = "server.service"

FILES_${PN} += "${systemd_unitdir}/system/cliente.service \
${systemd_unitdir}/system/server.service "

EXTRA_OECMAKE = ""