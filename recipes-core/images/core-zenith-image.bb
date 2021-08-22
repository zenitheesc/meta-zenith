SUMMARY = "core-zenith-image"
DESCRIPTION = "Base image for Zenith Aerospace's embedded Linux projects" 

LICENSE = "MIT"

inherit core-image 

export IMAGE_BASENAME = "core-zenith-image"
MACHINE_NAME ?= "${MACHINE}"
IMAGE_NAME = "${MACHINE_NAME}_${IMAGE_BASENAME}"

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += "splash"
CORE_IMAGE_EXTRA_INSTALL = "sdbus-c++ opencv"

