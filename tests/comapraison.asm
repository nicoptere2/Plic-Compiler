#Operation arithmetique!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#Operation arithmetique!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#Chargement de 5 dans $v0
li $v0, 5
#Chargement Operande gauche dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4

#Chargement de 9 dans $v0
li $v0, 9
#Chargement Operande droite dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4
#Chargement Operande droite dans $v0
addi $sp, $sp, 4
lw $v0, ($sp)
#Chargement Operande gauche dans $t8
addi $sp, $sp, 4
lw $t8, ($sp)
#Calcule de OperandeGauche @ OperandeDroite (@ => operateur)
#LowerThan 
slt $v0, $t8, $v0


#Chargement Operande gauche dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4

#Operation arithmetique!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#Operation arithmetique!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
#Chargement de 5 dans $v0
li $v0, 5
#Chargement Operande gauche dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4

#Chargement de 4 dans $v0
li $v0, 4
#Chargement Operande droite dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4
#Chargement Operande droite dans $v0
addi $sp, $sp, 4
lw $v0, ($sp)
#Chargement Operande gauche dans $t8
addi $sp, $sp, 4
lw $t8, ($sp)
#Calcule de OperandeGauche @ OperandeDroite (@ => operateur)
#Soustraction 
sub $v0, $t8, $v0


#Chargement Operande gauche dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4

#Chargement de 0 dans $v0
li $v0, 0
#Chargement Operande droite dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4
#Chargement Operande droite dans $v0
addi $sp, $sp, 4
lw $v0, ($sp)
#Chargement Operande gauche dans $t8
addi $sp, $sp, 4
lw $t8, ($sp)
#Calcule de OperandeGauche @ OperandeDroite (@ => operateur)
#GreaterThan 
sgt $v0, $t8, $v0


#Chargement Operande droite dans la pile
sw $v0, ($sp)
addi $sp, $sp, -4
#Chargement Operande droite dans $v0
addi $sp, $sp, 4
lw $v0, ($sp)
#Chargement Operande gauche dans $t8
addi $sp, $sp, 4
lw $t8, ($sp)
#Calcule de OperandeGauche @ OperandeDroite (@ => operateur)
#Multiplication 
mul $v0, $t8, $v0


