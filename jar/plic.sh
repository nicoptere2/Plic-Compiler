#!/bin/bash

if [ -n $1 ] && [ -n $2 ]
then
	outFile=$(echo $2 | sed -r 's/.plic/.asm/g')
	java -jar $1 $2 $outFile
	if [ ' ' != $MARSPATH ]
	then
		java -jar $MARSPATH $outFile
	else
		echo "MARSPATH variable d'environement non déclaré"
	fi

else
	echo "usage : ./plic fichier.plic classe.Main"
fi
