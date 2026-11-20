<?php
declare(strict_types=1);
$items = ['Design' => 'Ready', 'Build' => 'Ready', 'Device testing' => 'Pending'];
function e(string $v): string { return htmlspecialchars($v, ENT_QUOTES | ENT_SUBSTITUTE, 'UTF-8'); }
$ready = count(array_filter($items, static fn(string $v): bool => $v === 'Ready'));
?>
<!doctype html><html lang="en"><meta charset="utf-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Studio100 | Demo</title><style>
*{box-sizing:border-box}body{margin:0;background:#f4f6fa;font:16px system-ui,sans-serif;color:#172033}main{max-width:720px;margin:64px auto;padding:24px}header{margin-bottom:28px}h1{font-size:36px;margin:8px 0}small{color:#465774}section{background:white;border:1px solid #e1e6ef;border-radius:20px;padding:24px}progress{width:100%;accent-color:#3564df;height:16px}ul{padding:0;list-style:none}li{display:flex;justify-content:space-between;padding:14px 0;border-bottom:1px solid #e1e6ef;gap:16px}strong{color:#2456c6}footer{margin-top:22px;color:#465774}@media(max-width:480px){main{margin:18px auto;padding:16px}h1{font-size:28px}}:focus-visible{outline:3px solid #3564df}
</style><main><header><small>AGENTSTUDIO / EXAMPLES</small><h1>Project overview</h1><p>Local demonstration · PHP only</p></header><section><h2><?= $ready ?> of <?= count($items) ?> example milestones</h2><progress aria-label="Example milestones" value="<?= $ready ?>" max="<?= count($items) ?>"></progress><ul><?php foreach($items as $label=>$state): ?><li><span><?= e($label) ?></span><strong><?= e($state) ?></strong></li><?php endforeach; ?></ul><footer>Illustrative data, not actual QA results.</footer></section></main></html>
