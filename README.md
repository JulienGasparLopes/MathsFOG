# MathsFOG (Maths For OpenGl)
A mathematics library for modern OpenGL in Java

## Why do I need Maths ?
If you are using modern OpenGL (with LWJGL or JOGL) for the rendering of your app you should probably know ;)
The purpose of this library is to simplify the creation and manipulation of matrices when using OpenGL3 and shaders.
It allows you to generate matrices (4x4) and translate, rotate or scale them (for model and view matrices of shaders)
It provides simple functions to create Orthographic matrix to transform OpenGL base coordinate system (projection matrix for shaders)

## Features
Vertex/Vectors :
* Vertex2f(x,y) - float
* Vertex3f(x,y,z) - float
* Vertex4f(x,y,z,w) - float
* Translate, Scale, Getters/Setters for components

Matrices
* Matrix4f Unit - float
* Orthographic projection Matrix4f - float
* Rotation Matrix4f, Translation Matrix4f, Scaling Matrix4f
* Translate, Rotate, Scale matrices using matrices or vectors

## Show me some code
Create a Unit Matrix4f then scale, rotate and translate it (model matrix of shader for example)
```java
Matrix4f model = new Matrix4f() //Create a Unit Matrix4f
model = Matrix4f.scale(model, 3f); //Scale by 3 each axis (specify a Vertex3f for per axis scaling)
model = Matrix4f.rotate(model, new Vertex3f(0,0,1), 42); //Rotation of 42 degrees around Z axis
model = Matrix4f.translate(model, new Vertex2f(100, -20)); //Translate 100 unit in X and -20 unit in Y axis
```

If you're looking for an orthographic projection Matrix :
```java
//Horizontal : 0(left) to 400(right), Vertical : 0(bottom) to 500(top), Depth : 0(near) to 1(far)
Matrix4f projection = Matrix4f.getOrtho(0,0,400,500,0,1);
```

## Warning
This library is a Work In Progress, some features needs to be implemented or improved
This is the easiest implementation of Matrix operations, there is no optimization. You shouldn't use this by now if you're looking
for performances. Therefore it's a good library if you want to learn/implement OpenGL without having to implement Matrix logic.

Working with LWJGL3.1.5, should work with JOGL (any feedback would be appreciated !)

## Contribute
If you see any bug or have any suggestion of feature missing, create an issue or contact me ;)
