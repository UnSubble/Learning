-- SELECT username as '5_oldest_users' FROM users ORDER BY created_at ASC LIMIT 5;

-- SELECT DAYNAME(created_at) as 'day', COUNT(*) as 'count' FROM users GROUP BY day ORDER BY count DESC;

-- SELECT username FROM users WHERE id NOT IN (SELECT DISTINCT user_id FROM photos);

-- SELECT username, COUNT(*) as likes FROM users JOIN photos ON users.id = photos.user_id JOIN likes ON photos.id = likes.photo_id GROUP BY photos.id ORDER BY COUNT(*) DESC LIMIT 1; 

-- SELECT (SELECT COUNT(*) FROM photos) / (SELECT COUNT(*) FROM users);

-- SELECT tag_name, COUNT(*) as total_use FROM tags JOIN photo_tags ON tags.id = photo_tags.tag_id GROUP BY tag_name ORDER BY COUNT(*) DESC LIMIT 5;

-- SELECT username FROM users JOIN likes ON likes.user_id = users.id GROUP BY users.id HAVING COUNT(users.id) = (SELECT COUNT(*) FROM photos);