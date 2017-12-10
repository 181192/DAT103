section .bss
  n resb 1

section .text
  global _start

_start:
  mov ecx, 10
  mov eax, '1'

a:
  mov [n], eax
  mov eax, 4
  mov ebx, 1
  push ecx

  mov ecx, n
  mov edx, 1
  int 0x80

  mov eax, [n]
  sub eax, '0'
  inc eax
  add eax, '0'
  pop ecx
  loop a

  mov eax, 1
  mov ebx, 0
  int 0x80
