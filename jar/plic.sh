#!/bin/bash

path=$(pwd)

if [ $# -eq 2 ] 
then

	if [ -e plicCompiler.jar ]
	then
		outFile=$(echo $1 | sed -r 's/.plic/.asm/g')
		echo $outFile
		java -jar plicCompiler.jar $1 $outFile
	
		if [ $? -eq 0 ]
		then
			mv $outFile /tmp/
			cd /tmp/	
			if [ -n $MARSPATH ]
			then
				java -jar $MARSPATH $outFile
			else
				echo "MARSPATH variable d'environement non déclaré"
			fi
		
			cd $path
	
		fi
	else
		echo "le fichier plicCompiler.jar n'existe pas"
	fi

else
	echo "usage : ./plic fichier.plic classe"
fi
