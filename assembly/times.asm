section .text
  global _start

_start:
  mov edx, 9
  mov ecx, stars
  mov ebx, 1
  mov eax, 4
  int 80h

  mov eax, 1
  int 80h

section .data
  stars times 9 db '*'
