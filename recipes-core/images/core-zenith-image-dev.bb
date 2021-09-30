SUMMARY = "core-zenith-image-dev"
DESCRIPTION = "Base development image for Zenith's embedded Linux projects" 

LICENSE = "MIT"

inherit core-image 
require core-zenith-image.bb

export IMAGE_BASENAME = "core-zenith-image-dev"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

IMAGE_FEATURES += "tools-debug debug-tweaks"
CORE_IMAGE_EXTRA_INSTALL += "ethtool evtest fbset i2c-tools memtester git sysbench systemd-analyze can-utils"

