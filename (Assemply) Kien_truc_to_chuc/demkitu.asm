.model small
.stack 100h
.data
s1 db 'Nhap xau: $'
s2 db 10,13,'Nhap ki tu: $'
s3 db 10,13,'So luong ki tu vua nhap la: $'
s db 100 dup(?)
a dw 0
b dw 0
.code
main proc
    mov ax,@data
    mov ds,ax
    
    mov bx,0
    
    mov ah,9 
    lea dx,s1
    int 21h
nhaptiep:    
    mov ah,1
    int 21h
    
    cmp al,13
    je dungnhap
    
    mov s(bx),al
    inc bx
    jmp nhaptiep
dungnhap:
    mov ah,9
    lea dx,s2
    int 21h
    
    mov ah,1
    int 21h
    
    mov cx,bx
    mov bx,0
    mov dx,0
kiemtratiep:    
    cmp s(bx),al
    je tang
    jmp chaytiep
tang:
    inc dx
chaytiep:
    inc bx
    loop kiemtratiep
    
    mov bx,dx
    
    mov ah,9
    lea dx,s3
    int 21h   
    
    mov ax,bx 
    mov bx,10
    mov cx,0
chiatiep:
    mov dx,0
    
    div bx
    cmp ax,0
    je output
    
    push dx
    inc cx
    jmp chiatiep
output:    
    add dl,48
    mov ah,2
    int 21h
    
    cmp cx,0
    je dunglai
    
    pop dx
    add dl,48
    int 21h
dunglai:
    mov ah,4ch
    int 21h
    main endp
end main
    