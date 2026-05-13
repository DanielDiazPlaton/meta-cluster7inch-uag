SUMMARY = "Programa Monitor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://monitor.c \
           file://monitor.service"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "monitor.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} monitor.c -o monitor
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 monitor ${D}${bindir}

    install -d ${D}${systemd_system_unitdir}

    install -m 0644 ${WORKDIR}/monitor.service \
        ${D}${systemd_system_unitdir}
}