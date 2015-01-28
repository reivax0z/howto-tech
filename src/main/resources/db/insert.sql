DROP TABLE step;
DROP TABLE how_to;

CREATE TABLE how_to (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    intro VARCHAR(250)
);

CREATE TABLE step (
    id INT AUTO_INCREMENT PRIMARY KEY,
    howto_id INT,
    number INT,
    intro VARCHAR(250),
    content VARCHAR(500),
    picture_link VARCHAR(100),
    FOREIGN KEY (howto_id) REFERENCES how_to(id)
);

INSERT INTO how_to (title, intro)
VALUES (
  'Copy images to your computer?',
  'This step-by-step guide will explain to you how to copy images from a memory stick to your computer.'
  );

INSERT INTO how_to (title, intro)
VALUES (
  'Publish your pictures online?',
  'This step-by-step guide will explain to you how to upload images from your computer to Google+ (using Picasa) and share them with your friends and family.'
  );

INSERT INTO how_to (title, intro)
VALUES (
  'Manage your Gmail Contacts',
  'This step-by-step guide will explain to you how to manage (add/edit/remove entries in) your contact list of your Gmail account.'
  );

INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  1,
  'First, you need to plug in your memory stick.',
  'To do so, insert your memory stick (USB, memory card...) inside one of your computer slots.'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step  (howto_id, number, intro, content, picture_link)
  SELECT id,
  2,
  'Then, open the file explorer.',
  'Hit <code>Windows+E</code> (both keys at the same time). A new window appears. Then locate your memory stick in the opened window (should appear below the Disk Drives, in the left panel). Double-click on its icon to open its content.',
  'http://www.askdavetaylor.com/9-blog-pics/iphone-photos-windows-win7-3.png'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  3,
  'Select your pictures.',
  'Once the content is displayed, select the pictures you want to copy onto your computer. You can select them all (See <a href="#step4">step 4</a>) or only a range (See <a href="#step5">step 5</a>).'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  4,
  'Select all pictures.',
  'To do so, simply hit <code>Crtl+A</code> (both keys at the same time).'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  5,
  'Select only a range of pictures.',
  'To do so, simply maintain the key <code>Crtl</code> pressed and then click on each picture you want to select.'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  6,
  'Copy you pictures.',
  'To do so, simply hit <code>Crtl+C</code> (both keys at the same time).'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content, picture_link)
  SELECT id,
  7,
  'Select your destination folder.',
  'Hit <code>Windows+E</code> (both keys at the same time). A new window appears. Then locate your Pictures folder. Double-click on its icon to open its content.',
  'http://www.homeandlearn.co.uk/BC//win7/folders/library_pics.gif'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  8,
  'Paste your pictures.',
  'To do so, simply hit <code>Crtl+V</code> (both keys at the same time).'
  FROM how_to WHERE title='Copy images to your computer?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  9,
  'Well done!',
  'This is it, you''ve copied your pictures from your memory stick to your computer. Congratulations!'
  FROM how_to WHERE title='Copy images to your computer?';

INSERT INTO step  (howto_id, number, intro, content)
SELECT id,
  1,
  'First, open the Picasa software.',
  'Double click on the Picasa icon, or look for it in:<ol class="breadcrumb"><li>Start</a></li><li>Programs</a></li><li>Picasa</li></ol>Don''t have Picasa yet? Obtain it from the following link: <a href="http://picasa.google.com.au/" target="_blank"><button type="button" class="btn btn-info">Download Picasa</button></a>'
  FROM how_to WHERE title='Publish your pictures online?';
INSERT INTO step (howto_id, number, intro, content, picture_link)
  SELECT id,
  2,
  'Then, you need to locate the folder you want to share.',
  'As Picasa keeps up-to-date with the pictures on your computer, you should be able to locate all folders containing pictures. Select the folder that interests you.',
  'http://screenshots.en.sftcdn.net/en/scrn/23000/23941/picasa-01-700x512.png'
  FROM how_to WHERE title='Publish your pictures online?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  3,
  'Select your pictures.',
  'Once the content is displayed, select the pictures you want to upload online. You can select them all (See <a href="#step4">step 4</a>) or only a range (See <a href="#step5">step 5</a>).'
  FROM how_to WHERE title='Publish your pictures online?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  4,
  'Select all pictures.',
  'To do so, simply hit <code>Crtl+A</code> (both keys at the same time).'
  FROM how_to WHERE title='Publish your pictures online?';
INSERT INTO step (howto_id, number, intro, content)
  SELECT id,
  5,
  'Select only a range of pictures.',
  'To do so, simply maintain the key <code>Crtl</code> pressed and then click on each picture you want to select.'
  FROM how_to WHERE title='Publish your pictures online?';
INSERT INTO step (howto_id, number, intro, content, picture_link)
  SELECT id,
  6,
  'Publish them.',
  'To do so, simply hit the <code>Share</code> button in Picasa. You can then enter some details, such as the album name. And select which persons you want to share the album with (enter a name or an email address).',
  'http://picasageeks.com/wp-content/uploads/2014/05/album1.png'
  FROM how_to WHERE title='Publish your pictures online?';
INSERT INTO step (howto_id, number, intro, content, picture_link)
  SELECT id,
  7,
  'Well done!',
  'This is it, you''ve uploaded your pictures to Google+. They are now accessible directly in your Google+ profile. And the persons you have shared the album with have received a notification by email to check your photos. Congratulations!',
  'http://lh6.ggpht.com/Software.Thailand/R1T-OQKUFmI/AAAAAAAAALI/6MdfFf1IDrE/s800/Upload+manager.jpg'
  FROM how_to WHERE title='Publish your pictures online?';