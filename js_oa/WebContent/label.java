String label =
				"{\"algoSpecId\":1,\"algoSpecVersion\":1,\"authority\":{},\"basises\":{\"description\":\"1\","
				+ "\"normalItems\":[{\"duration\":{\"period\":\"999999\"},\"id\":\"a494090c-3d3e-4b97-9304-62e05b40baca\","
				+ "\"level\":50,\"name\":\" 绩效管理有关信息\"},"
				+ "{\"duration\":{\"period\":\"999999\"},\"id\":\"ac803f05-6d3f-4167-8884-c6b1310dc5b1\","
				+ "\"level\":50,\"name\":\" 公 司 人 工 成 本 信 息 及 相 关 统 计 数 据\"}],"
				+ "\"type\":10},\"drafter\":{\"id\":\"0e887468-f53a-46f8-aa6d-2562b4b79da0\",\"name\":\"test\"},"
				+ "\"duration\":{\"condition\":\"1\",\"period\":\"999999\"},\"fileAssetId\":\"\",\"fileContentId\":\"\","
				+ "\"fileUniqueId\":\"\",\"issuer\":{},\"labelSpecId\":1,\"labelSpecVersion\":1,\"level\":180,"
				+ "\"organs\":[{\"id\":\"37bf5a52-d5af-4fdd-a901-a487d8925471\",\"name\":\" 国务院\"}],"
				+ "\"scope\":{\"description\":\"1\"},\"status\":110}";

				// 打印结果如下
				{"algoSpecId":1,"algoSpecVersion":1,"authority":{},"basises":{"description":"1",
					"normalItems":[{"duration":{"period":"999999"},"id":"a494090c-3d3e-4b97-9304-62e05b40baca",
				    "level":50,"name":" 绩效管理有关信息"},
					 {"duration":{"period":"999999"},"id":"ac803f05-6d3f-4167-8884-c6b1310dc5b1",
					"level":50,"name":" 公 司 人 工 成 本 信 息 及 相 关 统 计 数 据"}],
					"type":10},"drafter":{"id":"0e887468-f53a-46f8-aa6d-2562b4b79da0","name":"test"},
					"duration":{"condition":"1","period":"999999"},"fileAssetId":"","fileContentId":"",
					"fileUniqueId":"","issuer":{},"labelSpecId":1,"labelSpecVersion":1,"level":180,
					"organs":[{"id":"37bf5a52-d5af-4fdd-a901-a487d8925471","name":" 国务院"}],
					"scope":{"description":"1"},"status":110}
					
				// 没有histories, keys

				// 没有algoSpecId & algoSpecVersion
				{"algoSpecId":1,"algoSpecVersion":1,

				// authority
				// 没有id & name
				"authority":{},

				// basises
				// 没有derivedItems.
				// description
				"basises":{"description":"1",
				// normalItems
				// normalItems 的duration, id, level, name
				// normalItems 没有scape & keys
				"normalItems":[
				{"duration":{"period":"999999"},"id":"a494090c-3d3e-4b97-9304-62e05b40baca","level":50,"name":" 绩效管理有关信息"},
				{"duration":{"period":"999999"},"id":"ac803f05-6d3f-4167-8884-c6b1310dc5b1","level":50,"name":" 公 司 人 工 成 本 信 息 及 相 关 统 计 数 据"}],
				// type
				"type":10},

				// drafter - "id":"xxxxxx","name":"xxxxxx"
				"drafter":{"id":"0e887468-f53a-46f8-aa6d-2562b4b79da0","name":"test"},

				// duration - ”condition“:"x","period":"xxxxxx"
				// 没有classifiedTime & declassifiedTime
				"duration":{"condition":"1","period":"999999"},

				// 没有fileAssetId, fileContentId, fileUniqueId
				"fileAssetId":"","fileContentId":"","fileUniqueId":"",

				// issuer
				// 没有id & name
				"issuer":{},

				// 没有labelSpecId & labelSpecVersion
				"labelSpecId":1,"labelSpecVersion":1,
				"level":180,

				// organs - "id":"xxxxxx","name":"xxxxxx"
				"organs":[{"id":"37bf5a52-d5af-4fdd-a901-a487d8925471","name":" 国务院"}],

				// scope - “description":"1"
				// 没有staffs, groups, units
 				"scope":{"description":"1"},
				
				// status - xxx
				"status":110}
