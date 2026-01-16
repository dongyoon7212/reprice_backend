
select
	crt.chat_room_id,
    crt.product_id,
    pt.title,
    pt.status as sell_status,
    pit.image_url,
    crt.seller_id,
    ut.display_name as seller_display_name,
    crt.buyer_id,
    uut.display_name as buyer_display_name,
    lm.content,
    lm.sent_dt
from
	chat_room_tb crt
join
	product_tb pt on (crt.product_id = pt.product_id)
join
	product_image_tb pit on (crt.product_id = pit.product_id AND pit.thumbnail = 1)
join
	user_tb ut on (crt.seller_id = ut.user_id)
join
	user_tb uut on (crt.buyer_id = uut.user_id)
LEFT JOIN (
    SELECT chat_room_id, content, sent_dt
    FROM (
        SELECT
            chat_room_id,
            content,
            sent_dt,
            chat_message_id,
            ROW_NUMBER() OVER (
                PARTITION BY chat_room_id
                ORDER BY sent_dt DESC, chat_message_id DESC
            ) AS rn
        FROM chat_message_tb
    ) t
    WHERE rn = 1
) lm
  ON lm.chat_room_id = crt.chat_room_id
where
	crt.seller_id = 3
	or crt.buyer_id = 3
-- group by
-- 	*
order by
	crt.last_message_dt desc;