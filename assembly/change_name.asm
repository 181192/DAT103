section .text
  global _start

section .data
  name db 'Zara Ali '

_start:

  ; Writing the name 'Zara Ali'
  mov edx, 9
  mov ecx, name
  mov ebx, 1
  mov eax, 4
  int 80h

  ; Change the f name to Test Ali
  mov [name], dword 'Test'

  ; Writing the name 'Test Ali'
  mov edx, 8
  mov ecx, name
  mov ebx, 1
  mov eax, 4
  int 80h

  mov eax, 1
  int 80h


