require('dotenv').config()

const app = require('./app');
const port = 3000;
require('./database');
require('./redis/blocklist');
require('./redis/allowlis-refresh-token');

const routes = require('./rotas');
routes(app);

app.listen(port);
