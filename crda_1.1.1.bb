 DESCRIPTION = "Wireless Central Regulatory Domain Agent"
HOMEPAGE = "http://wireless.kernel.org/en/developers/Regulatory/CRDA"
SECTION = "base"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=07c4f6dea3845b02a18dc00c8c87699c"

PR = "r0"

DEPENDS = "libgcrypt libnl python-native python-m2crypto-native"
RDEPENDS_${PN} = "udev"

SRC_URI = "ftp://www.kernel.org/pub/software/network/crda/${BP}.tar.bz2;name=crda \
           ftp://www.kernel.org/pub/software/network/wireless-regdb/wireless-regdb-2013.01.11.tar.gz;name=bin \
"


EXTRA_OEMAKE = "MAKEFLAGS="
do_compile() {
    oe_runmake all_noverify
}

do_install() {
    oe_runmake DESTDIR=${D} install
    install -d ${D}/usr/lib/crda/
    install -m 0644 ${WORKDIR}/2011.04.28-regulatory.bin ${D}/usr/lib/crda/regulatory.bin
}

SRC_URI[crda.md5sum] = "5fc77af68b3e21736b8ef2f8b061c810"
SRC_URI[crda.sha256sum] = "59b4760da44a8f803caeaaa7fb97e0c6bd3f35f40445b28258e7f14c2fbe13b5"
SRC_URI[reg.md5sum] = "1535e98bcaba732e2f8e8f62dac6f369"
SRC_URI[reg.sha256sum] = "bb6ba6f5dcdf7106a19c588b0e4d43ab7af26f6474fe01011a318b3dceaba33b"

FILES_${PN} += "\
    /lib/udev/rules.d/85-regulatory.rules \
    /usr/lib/crda/regulatory.bin \
"
