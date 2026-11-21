SUMMARY = "Programa Monitor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/DanielDiazPlaton/ACC_cluster_app_yocto.git;protocol=https;branch=scarthgap"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "monitor.service"
SYSTEMD_AUTO_ENABLE = "enable"


# ----------------------------------------------------------------------
# Instalación del servicio respetando 'usrmerge'
# ----------------------------------------------------------------------
do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/monitor.service ${D}${systemd_system_unitdir}/monitor.service
}

# ----------------------------------------------------------------------
# Empaquetado oficial respetando la variable de systemd
# ----------------------------------------------------------------------
FILES:${PN} += "${systemd_system_unitdir}"













#do_compile() {
#    ${CC} ${CFLAGS} ${LDFLAGS} monitor.c -o monitor
#}

#do_install() {
#    install -d ${D}${bindir}
#    install -m 0755 monitor ${D}${bindir}

#    install -d ${D}${systemd_system_unitdir}
#
#    install -m 0644 ${WORKDIR}/monitor.service \
#        ${D}${systemd_system_unitdir}
#}
