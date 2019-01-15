CREATE VIEW top AS SELECT DISTINCT Idea_id, COUNT(VoteEnum) FROM vote WHERE VoteEnum = 2 GROUP BY Idea_id ORDER BY COUNT(VoteEnum) DESC LIMIT 3;