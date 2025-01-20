<h1>API REST de foro para realizar comnetarios</h1>
<h4>Con este API REST puedes:</h4>

<p>1. Generar el token para el login del usuario</p>

![image](https://github.com/user-attachments/assets/0b21089a-90d5-4484-8730-da57b7e752e1)






<p>2. Una vez se haya autenticado con el token, puede registrar tópicos: </p>

![image](https://github.com/user-attachments/assets/178dc343-fae3-414c-b7a4-08a860cbd8ba)








<p>3. Tmabién, listar los tópicos que se encuentran activos</p>

![image](https://github.com/user-attachments/assets/3f29239c-6cbb-4422-b5f5-5c1864f216b1)






<p>4. Además, Actualizar los datos de dos maneras:</p>
<p> - Una de ellas, le permite poner "SOLUCIONADO" cuando el usuario haya obtenido una respuesta satisfactoria a su pregunta. Se colocará (SOLUCIONADO) al principio del título</p>

![image](https://github.com/user-attachments/assets/b3144bee-6543-498b-821a-2e8d11fa7ca6)






<p> - La segunda manera le permite actualizar el tópico por titulo y/o mensaje</p>

![image](https://github.com/user-attachments/assets/8cc6bd27-1909-4e37-9acc-4163f10f7861)






<p>5. Finalmente, se puede eliminar un tópico. Si bien no se elimina de la base de datos, su status cambia a false por lo cual ya no se enlista al hacer un get al http://localhost:8080/topicos</p>

![image](https://github.com/user-attachments/assets/61deb026-1567-4e88-ae22-2aaad986e514)





![image](https://github.com/user-attachments/assets/9b822256-d9e9-409d-bf7c-1321be34c595)







![image](https://github.com/user-attachments/assets/b73c96cd-5b89-4e85-8d06-03fb7f1d339f)






<p>Se puede observar que no todas se enlistas pues algunas se encuentran con status false</p>




