cr equ 13
lf equ 10

section .text
  global _start

section .data
  choice DB 'y',cr,lf
  len equ $ - choice

_start:
  mov edx, len
  mov ecx, choice
  mov ebx, 1
  mov eax, 4
  int 0x80

  mov eax, 1
  int 0x80
