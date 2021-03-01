.model
.stack
.data
s1 db 'Nhap xau: $'
s2 db 10,13,'Nhap ki tu muon thay doi: $'
s3 db 10,13,'Xau sau khi bien doi: $'
s db 100 dup(?)
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
    mov dx,bx
    mov bx,0
kiemtratiep:    
    cmp s(bx),al
    je transform
    jmp chaytiep
transform:
    sub s(bx),32  
chaytiep:
    inc bx
    loop kiemtratiep
    
    mov s(bx),'$'
    mov ah,9
    lea dx,s3
    int 21h
    
    lea dx,s
    int 21h
    mov ah,4ch
    int 21h
    main endp
end main
    
    