# Endless-Runner-Game
OOP running game project by 59070001 นายกชสม คำวังเงี้ยว 59070018 นายกิตติศักดิ์ ไพรสุทธิรัตน 59070102 นายปิยะวัฒน์ ช่วงกรุด

มี OOP Project (ส่วนของ source code), endlessrunnergame.jar (ตัวเกมโหลดแล้วrunได้เลย), story board อธิบายการทำงานพื้นฐานของเกม

โค้ดหลักของเกมจะอยู่ใน ไฟล์ OOP project โดยจะแบ่งเป็น 2 ส่วนคือส่วน desktop และ core

ในส่วนของ desktop จะเป็นของการ set ค่าหน้าจอโดยเกมนี้จะล็อคขนาดของหน้าจอเป็น800*480

ในส่วนของ core จะเป็ฯการทำงานหลักของเกม โดยในที่นี้จะแบ่งเป็น 8Packages

1.packages endlessrunning 

  ส่วนนี้จะextends Game มาแล้วเรียก MainScreen.java
  
2.packages  actors

  packagesนี้ จะเป็นกาสร้างตัวละครต่างๆ โดยเริ่มจาก MainActor แล้วไฟล์ Enemy Runner Ground ก็จะextendsมา แล้วมาเปลี่ยนให้เหมาะสมกับตัวละครนั้นๆ

3.package box2d

  packagesนี้ จะเป็นการset ค่าdataพื้นฐาน เช่น ค่าposition โดยเริ่มจาก Userdata แล้วไฟล์อื่นๆก็extendsมาปรับให้เหมาะสม
  
4.package enums
  
  เป็นการsetค่าคงที่เพื่อให้เป็นเงื่อนไขบางอย่างที่จะใช้ใน MainStage เช่นสถานะของเกม จะเก็บอยู่ใน state
  
5.packages menu

  ส่วนนี้จะเป็นการsetค่าปุ่มต่างๆ รวมถึงค่าอื่นๆเพิ่มเติมที่เกี่ยวข้องกับส่วนของเมนู
  
6.packages screens

  ส่วนนี้เป็นส่วนที่เราไว้set screen แล้วเรียกMain Stage ซึ่งจะเป็นส่วนหลักของเกม

7.packages stage *****ตัวเอกของเกม

  ส่วนนี้จะเป็นส่วนของการทำงานหลักของเกม โดยpackages ต่างๆจะถูกนำมาใช้ในที่นี่ แนะนำว่าเข้ามาดูที่MainStage.java แล้วไฟล์นี้จะเรียกค่าจากไฟล์ต่างมาใช้เอง
    
8.packages utility
 
  ส่วนนี้จะเป็นอรรถประโยชน์ เช่น การrandomการเกิดของenemy หรือ เก็บconstants 
  
