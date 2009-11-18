DESCRIPTION = "Xerces-c is a validating xml parser written in C++"
HOMEPAGE = "http://xerces.apache.org/xerces-c/"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "r2"

SRC_URI = "http://mirror.serversupportforum.de/apache/xerces/c/2/sources/xerces-c-src_2_8_0.tar.gz \
           file://nolocallink.patch;patch=1"
S = "${WORKDIR}/xerces-c-src_2_8_0/src/xercesc"

inherit autotools pkgconfig

CCACHE = ""
export XERCESCROOT="${WORKDIR}/xerces-c-src_2_8_0"
export cross_compiling = "yes"

do_configure() {
	./runConfigure -plinux -c"${CC}" -x"${CXX}" -minmem -nsocket -tnative -rpthread -P${D}${prefix} \
                    -C--build=${BUILD_SYS} \
                    -C--host=${HOST_SYS} \
                    -C--target=${TARGET_SYS} \
}

do_compile() {
	${MAKE}
}

do_install () {
	${MAKE} install
}
