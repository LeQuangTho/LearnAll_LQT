.model small
.stack 100h
.data
s1 db 'Nhap xau: $'
s2 db 10,13,'Xau vua nhap: $'
a db 100 dup(?)
.code
main proc
    mov ax,@data
    mov ds,ax
    
    mov ah,9
    lea dx,s1
    int 21h
    
    mov bx,1
nhaptiep:    
    mov ah,1
    int 21h
    
    cmp al,13
    je dungnhap
    
    mov a(bx),al
    inc bx
    jmp nhaptiep
dungnhap:
    mov cx,bx
    ;mov bx,0
    
    mov ah,9
    lea dx,s2
    int 21h
intiep:    
    mov dl,a(bx)
    mov ah,2
    int 21h
    dec bx
    loop intiep
    
    mov ah,4ch
    int 21h
    main endp
end main