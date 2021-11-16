<h1 align="center" style="color:white; background-color:black">meta-zenith</h1>
<h4 align="center">This project is a Linux Distro booted with Systemd and designed to run on an Embedded System with the required components by Zenith, having the daemons and drivers developed by the group</h4>

<p align="center">
	<a href="http://zenith.eesc.usp.br/">
    <img src="https://img.shields.io/badge/Zenith-Embarcados-black?style=for-the-badge"/>
    </a>
    <a href="https://eesc.usp.br/">
    <img src="https://img.shields.io/badge/Linked%20to-EESC--USP-black?style=for-the-badge"/>
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/blob/main/LICENSE">
    <img src="https://img.shields.io/github/license/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge"/>
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/issues">
    <img src="https://img.shields.io/github/issues/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge"/>
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/commits/main">
    <img src="https://img.shields.io/github/commit-activity/m/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge">
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge"/>
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/commits/main">
    <img src="https://img.shields.io/github/last-commit/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge"/>
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/issues">
    <img src="https://img.shields.io/github/issues-raw/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge" />
    </a>
    <a href="https://github.com/${{ env.REPOSITORY_FULL_NAME }}/pulls">
    <img src = "https://img.shields.io/github/issues-pr-raw/${{ env.REPOSITORY_FULL_NAME }}?style=for-the-badge">
    </a>
</p>

<p align="center">
    <a href="#environment-and-tools">Environment and Tools</a> •
    <a href="#steps-to-run-and-debug">Steps to run and debug</a> •
    <a href="#how-to-contribute">How to contribute?</a> •
</p>

## Environment and tools

`Dependencies:
	• Poky (dunfell branch)
	• Meta-openembedded/meta-oe
	• Meta-openembedded/meta-python
	• Meta-raspberrypi`

## Steps to run and debug

This project has two images: core-zenith-image (production without development tools) and core-zenith-image-dev (includes development tools) 

To run the development image:
	
	• Enter in the poky file and run:
	$ source oe-init-build-env

	• Build the ZenithOs image by running:
	$ bitbake core-zenith-image-dev
	
	• After the image be generated, it is already to run:
	$ runqemu core-zenith-image-dev nographic
	
To run the production image:
	
	• Enter in the poky file and run:
	$ source oe-init-build-env

	• Build the ZenithOs image by running:
	$ bitbake core-zenith-image
	
	• After the image be generated, it is already to run:
	$ runqemu core-zenith-image nographic

## How to contribute

`Report bugs and/or feature-requests on our issue tab. Maybe there's something there waiting for you to work on!`

---

<p align="center">
    <a href="http://zenith.eesc.usp.br">
    <img src="https://img.shields.io/badge/Check%20out-Zenith's Oficial Website-black?style=for-the-badge" />
    </a> 
    <a href="https://www.facebook.com/zenitheesc">
    <img src="https://img.shields.io/badge/Like%20us%20on-facebook-blue?style=for-the-badge"/>
    </a> 
    <a href="https://www.instagram.com/zenith_eesc/">
    <img src="https://img.shields.io/badge/Follow%20us%20on-Instagram-red?style=for-the-badge"/>
    </a>

</p>
<p align = "center">
<a href="zenith.eesc@gmail.com">zenith.eesc@gmail.com</a>
</p>
