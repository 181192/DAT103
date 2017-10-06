cr equ 13
lf equ 10

section .text
  global _start ; must be declared for linker (ld)

_start:
  mov edx,len
  mov ecx,msg
  mov ebx,1
  mov eax,4
  int 0x80

  mov eax,1
  int 0x80

section .data
msg db 'Hello, everybody!',cr,lf
len equ $ - msg
