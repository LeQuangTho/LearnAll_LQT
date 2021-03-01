.model small
.stack 100h
.data
s1 db 'Nhap so nhan: $'
s2 db 10,13,'Nhap so bi nhan: $'
s3 db 10,13,'Ket qua la: $'
a dw 0
b dw 0
c dw 0
.code
main proc
    mov ax,@data
    mov ds,ax
    
    mov bx,10
    
    mov ah,9
    lea dx,s1
    int 21h
continue1:    
    mov ah,1
    int 21h
    
    cmp al,13
    je stop1
    
    sub al,48
   
    mov ah,0
    mov a,ax
    mov ax,b
    mul bx
    add ax,a
    mov b,ax
    jmp continue1
stop1:
    mov ah,9
    lea dx,s2
    int 21h
    
continue2:    
    mov ah,1
    int 21h
    
    cmp al,13
    je stop2
    
    sub al,48
   
    mov ah,0
    mov a,ax
    mov ax,c
    mul bx
    add ax,a
    mov c,ax
    jmp continue2
    
    
stop2:
    mov ah,9
    lea dx,s3
    int 21h
    
    mov dx,0
    mov ax,b
    mul c
    
    mov cx,0
continueDiv:
    mov dx,0
    div bx
    
    cmp ax,0
    je output
    
    push dx
    inc cx
    jmp continueDiv
    
output:
    add dl,48
    mov ah,2
    int 21h
    
    cmp cx,0
    je stopHere
continueOutput:    
    pop dx
    add dl,48
    int 21h
    loop continueOutput
stopHere:    
    mov ah,4ch
    int 21h
    main endp
end main
    
    
    
    
    