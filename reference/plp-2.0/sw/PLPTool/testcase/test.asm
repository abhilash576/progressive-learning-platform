          
# Test assembly

	.org 0x0
        j loop
init:
	.word 0xBEEFCAFE
	.word 0xAA
	addu $2, $1, $3  #  sdfsdfsdf

.include df.asm


somevar:
        .word 0xDEADBEEF

	.org 0x80
loop:

	lui  $3,50    #dfdsfsdf
	nop
	nop
	sll $1,$1,0x1 #SDSD

	addiu $2,  $3,   0b100100   
        lw $3,   40($2)
	bne $0,$0,loop
        li $6,somevar
        li $7,0xFEFEDADA

        nop
        nop
        beq $0,$0,exit
        nop

exit:
        nop
        nop
	beq $t4,$0,loop
