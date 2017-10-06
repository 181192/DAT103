section .text
  global _start

_start:
  mov ax, '8'
  sub ax, '0'

  mov bl, '2'
  sub bl, '0'
  div bl
  add ax, '0'

  mov [res], ax
  mov ecx, msg
  mov edx, len
  mov ebx, 1 ; STDOUT
  mov eax, 4 ; SYS_WRITE
  int 80h

  mov ecx, res
  mov edx, 1
  mov ebx, 1 ; STDOUT
  mov eax, 4 ; SYS_WRITE
  int 80h

  mov eax, 1 ; SYS_EXIT
  int 80h

section .data
  msg db "The result is:", 0xA, 0xD
  len equ $ - msg
  segment .bss
  res resb 1
