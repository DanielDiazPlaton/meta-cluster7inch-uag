SUMMARY = "Programa Monitor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://monitor.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} monitor.c -o monitor
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 monitor ${D}${bindir}
}