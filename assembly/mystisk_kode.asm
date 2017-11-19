cr equ 13 ; Carriage Return
lf equ 10 ; Line Feed

SYS_EXIT equ 1
SYS_WRITE equ 4
STDOUT equ 1
STDERR equ 2

section .bss
	a resb 4

section .data
	crlf db cr, lf
	crlflen equ $ - crlf

section .text
global _start

_start:
	mov [a], byte 0
	mov eax, 0
	call hvis
slutt:
	call nylinje
	call _exit

;Lokken begynner her
hvis:
	cmp eax, 10
	jl mindre
	call else
lokke:
	inc eax
	cmp eax, 20
	jl hvis
	call slutt
mindre:
	mov ebx, [a]
	inc ebx
	mov [a], ebx
	call lokke
else:
	mov ebx, [a]
	dec ebx
	mov [a], ebx
	call lokke
nylinje:
	push eax
	push ebx
	push ecx
	push edx
	mov eax, SYS_WRITE
	mov ebx, STDOUT
	mov ecx, [a]
	add ecx, '0'
	mov [a], ecx
	mov ecx, a
	mov edx, 1
	int 80h
	mov eax, SYS_WRITE
	mov ebx, STDOUT
	mov ecx, crlf
	mov edx, crlflen
	int 80h
	pop edx
	pop ecx
	pop ebx
	pop eax
	ret
_exit:
	mov eax, SYS_EXIT
	mov ebx, 0
	int 80h
