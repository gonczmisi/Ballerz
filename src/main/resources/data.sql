-- Adding some events for testing
INSERT INTO event(name, type, organizer, venue, event_from, event_to, created_at, updated_at) VALUES('single match', 'SINGLE_MATCH', 'test organizer', 'test venue', CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());
INSERT INTO event(name, type, organizer, venue, event_from, event_to, created_at, updated_at) VALUES('tournament', 'TOURNAMENT', 'test organizer', 'test venue', CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());

-- Adding some matches for testing
INSERT INTO match(event_id, type, maximum_player_num, current_player_num, match_from, match_to, created_at, updated_at) VALUES(1, 'FRIENDLY_MATCH', 8, 0, CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());
INSERT INTO match(event_id, type, maximum_player_num, current_player_num, match_from, match_to, created_at, updated_at) VALUES(2, 'CUP_MATCH', 6, 0, CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());
INSERT INTO match(event_id, type, maximum_player_num, current_player_num, match_from, match_to, created_at, updated_at) VALUES(2, 'CUP_MATCH', 6, 0, CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());
INSERT INTO match(event_id, type, maximum_player_num, current_player_num, match_from, match_to, created_at, updated_at) VALUES(2, 'CUP_MATCH', 6, 0, CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME(), CURRENT_TIME());

-- Adding users
INSERT INTO user(username, password, email_address, enabled, type, created_at, updated_at) VALUES('admin', 'admin', 'admin@ballerz.com', true, 'ADMIN', CURRENT_TIME(), CURRENT_TIME());
INSERT INTO user(username, password, email_address, enabled, type, created_at, updated_at) VALUES('normal', 'normal', 'normal@ballerz.com', true, 'NORMAL', CURRENT_TIME(), CURRENT_TIME());

-- Adding players
INSERT INTO player(id, position) VALUES(2, 'GOALKEEPER');
