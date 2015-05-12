#!/bin/bash

if [ -n $1 ] && [ -n $2 ]
then
	echo $2
	outFile=$(echo $2 | sed -r 's/.plic/.asm/g')
	echo $outFile
	java -jar $1 $2 $outFile
	java -jar $MARSPATH $outFile

else
	echo "usage : ./plic fichier.plic classe.Main"
fi
