FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

#PACKAGECONFIG_remove = "timesyncd"
#SYSTEMD_AUTO_ENABLE_timesyncd = "disable"
PACKAGECONFIG_append_pn-systemd = "--disable-timesyncd"

SRC_URI += " \
    file://eth.network \
    file://en.network \
    file://wlan.network \
    file://can.network \
"

FILES_${PN} += " \
    ${sysconfdir}/systemd/network/eth.network \
    ${sysconfdir}/systemd/network/en.network \
    ${sysconfdir}/systemd/network/wlan.network \
    ${sysconfdir}/systemd/network/can.network \
"


do_install_append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/en.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/can.network ${D}${sysconfdir}/systemd/network
    rm -rf /etc/systemd/system/multi-user.target.wants/nfs-statd.service
    rm -rf /etc/systemd/system/multi-user.target.wants/nfs-server.service
    rm -rf /etc/systemd/system/multi-user.target.wants/nfs-mountd.service
}
