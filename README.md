משימה: חילוץ מידע על הנהרות הארוכים בעולם מתוך אתר ויקיפדיה. 
תקציר: עליכם ליצור web-scrapper שמחלץ, עבור כל אחד מרשימת הנהרות הארוכים בעולם, את המידע הבא: שם הנהר, אורך הנהר בקילומטרים, אורך הנהר במיילים, אזור הניקוז של הנהר. 


הוראות מפורטות: 
1: ראשית, עליכם להוריד מ-github את הפרויקט מהקישור הבא: 
2: התחברו לדף הוויקיפדיה הבא, המכיל רשימה של הנהרות הארוכים בעולם: https://en.wikipedia.org/wiki/List_of_rivers_by_length
3: נתחו את מבנה דף האינטרנט, כדי להבין היכן מאוחסן המידע הרלוונטי. 
4: תכננו כיצד לחלץ את הנתונים האלה, לפי מבנה ה-HTML. 
5: בשלב חילוץ הנתונים, שימו לב לנקודות הבאות:
5.1: כדי לחלץ את שם הנהר, כל שעליכם לעשות הוא לגשת אל המשבצת המתאימה בטבלה, עמודה בשם (River) ולחלץ את כל התוכן שלה. 
5.2: כדי לחלץ את אורך הנהר בקילומטרים תצטרכו לעבוד קשה יותר. המידע נמצא בעמודה בשם Length (km). בחלק מהרשומות, במשבצת הרלוונטית יש מידע נוסף, חלקו אינו מספרי. תצטרכו לנקות את המידע המיותר ולחלץ רק את המספר הראשון שקיים במשבצת. לדוגמה, אם המידע נראה כך: 6,650[3] (7,008)[9] – עליכם לחלץ מתוך הטקסט הזה רק את המספר 6650. 
5.3: את אותן הפעולות תצטרכו לבצע גם עבור העמודות המייצגות את אורך הנהר במיילים Length (miles) ואזור הניקוז – Drainage area. 
6: עבור כל רשומה בטבלת הנהרות, עליכם ליצור אובייקט של River. מחלקה זו קיימת בפרויקט שלכם. 
7: לבסוף, עליכם לזמן את המתודה ApiUtil.send שמצפה לקבל רשימה של אובייקטים מסוג River. נסו לחלץ כמה שיותר אובייקטים של נהרות. 
